package com.sisait.myapp.controller;

import com.sisait.myapp.entity.DataEntity;
import com.sisait.myapp.entity.FileEntity;
import com.sisait.myapp.entity.PagingVO;
import com.sisait.myapp.service.DataService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins="*")
public class DataController {
    private final DataService dataService;

    // 자료실 목록
    @GetMapping("/dataList")
    public Map<String,Object> dataList(PagingVO pVO, @PageableDefault(sort="id",direction= Sort.Direction.DESC) Pageable pageable){
        Map<String,Object> map = new HashMap<String, Object>();
        // pagingVO
        pVO.setTotalRecord(dataService.dataTotalRecord(pVO));
        map.put("pages", pVO);
        // 원글
        map.put("dataList",dataService.dataList(pVO));
        // 첨부파일


        return map;

    }


    @PostMapping("/dataWrite")
    @Transactional(rollbackFor = {RuntimeException.class, SQLException.class}) // 트랜젝션 : 원글 + 첨부파일 만큼 insert
    public String dataWrite(DataEntity dataEntity, HttpSession session){
        // 파일 저장할 위치
        String uploadPath = session.getServletContext().getRealPath("/uploads");

        List<FileEntity> fileEntity = null ; // 업로드한 파일의 정보 담기, 에러 나면 지울 때 필요함

        try {
           //파일 업로드 할 폴더가 없으면 생성
            File uploadDir = new File(uploadPath);
           if(!uploadDir.exists()){// uploads폴더가 있으면 true, 없으면 false
               uploadDir.mkdir();// 폴더생
           }
            // 원글 레코드 추가
           DataEntity resultEntity = dataService.dataInsert(dataEntity);

           // 파일 업로드: 파일명,확장자,파일크기,원글번호 FileEntity를 List에 담아야한다.
           fileEntity = fileuploadProcess(dataEntity.getFiles(), resultEntity.getId(),uploadPath);

           // 트랜잭션 : 원글 + 첨부파일 수 만큼 insert
            int cnt = dataService.fileListInsert(fileEntity);
            System.out.println("cnt=>"+cnt);


       }catch (Exception e){
            // 예외 발생했을 때
            // 이미 업로드된 파일 삭제
            if(fileEntity!=null){
                for(FileEntity entity : fileEntity){
                    File delFile = new File(uploadPath, entity.getFilename()+"."+entity.getExtname());
                    delFile.delete();
                }
            }
            // 롤백
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
           return "OK";
    }
    //파일 업로드
    public List<FileEntity> fileuploadProcess(List<MultipartFile> fileList,Integer id, String uploadPath) throws Exception{
        // 업로드한 파일 정보를 담을 List생성
        List<FileEntity> uploadfileList = new ArrayList<FileEntity>();
        if(fileList != null){
            for(MultipartFile mf : fileList){// 업로드한 MultipartFile 객체만큼 반복 수행
                if(mf!=null) {
                    String uploadFilename = mf.getOriginalFilename(); // 원래 파일명
                    int point = uploadFilename.lastIndexOf(".");

                    String filename = uploadFilename.substring(0, point); // 파일명

                    String extname = uploadFilename.substring(point + 1); // 확장자

                    File f = new File(uploadPath, uploadFilename);
                    if (f.exists()) { // 있으면 true, 없으면 false
                        for (int num = 1; ; num++) {
                            String newFilename = filename + "(" + num + ")." + extname;
                            f = new File(uploadPath, newFilename);
                            if (!f.exists()) { // 새로 만든 파일이 없으면 중단
                                uploadFilename = newFilename;
                                break;
                            }
                        }

                    }
                    // 있으면 업로드
                    mf.transferTo(f);
                    // 파일에 관련된 정보를 FileEntity에 담기 -> List
                    FileEntity fEntity = new FileEntity();
                    point = uploadFilename.lastIndexOf(".");
                    fEntity.setFilename(uploadFilename.substring(0, point));
                    fEntity.setExtname(uploadFilename.substring(point + 1));
                    fEntity.setSize((int) f.length()); // 파일크기

                    // dataEntity 설정
                    DataEntity data = new DataEntity();
                    data.setId(id);
                    fEntity.setDataEntity(data);

                    uploadfileList.add(fEntity);
                }
            }
        }

        return uploadfileList;
    }
    // 글내용보기
    @GetMapping("/dataDetail/{id}")
    public Map<String,Object> dataDetail(@PathVariable("id") int id){
        // 조회수 증가
        dataService.hitCount(id);

        Map<String, Object> dataMap= new HashMap<String, Object>();
        // 원글 : DataEntity
        dataMap.put("data", dataService.dataSelect(id).get());

        // 첨부파일 : List<FileEntity>
        List<FileEntity> fileList = dataService.fileSelect(id);
        dataMap.put("fileList",fileList);

        return dataMap;
    }
    //자료실 글 수정하기(DB)
    @PostMapping("/dataEditOk")
    @Transactional(rollbackFor={RuntimeException.class, SQLException.class})
    public ResponseEntity<String> dataEditOk(DataEntity dataEntity, HttpSession session){
        System.out.println(dataEntity);
        String uploadPath = session.getServletContext().getRealPath("/uploads");
        List<FileEntity> newUploadFile =null;
        try{
            //1.새로 업로드 한 파일이 있으면 업로드
            //fileuploadProcess(List<MultipartFile> fileList, Integer id, String uploadPath)
            newUploadFile = fileuploadProcess(dataEntity.getFiles(), dataEntity.getId(), uploadPath);

            //새로 업로드한 파일 정보 레코드 추가
            int fileCnt = dataService.fileListInsert(newUploadFile);

            // 삭제 된 파일 : 레코드를 먼저 삭제하면 파일 삭제시 파일명이 없으므로 미리
            // DB에 있는 삭제할 파일 목록을 선택한다.
            List<FileEntity> delFileList = dataService.fileIdSelect(dataEntity.getDelFile());
            for(FileEntity f: delFileList){
                System.out.println("삭제예정 파일 정보==>"+f.toString());
            }
            // 삭제한 파일의 레코드 지우기
            int delCnt = dataService.fileDelete(dataEntity.getDelFile());

            //원글 업데이트
            int dataCnt = dataService.dataUpdate(dataEntity);

            //삭제하기 위해 선택한 파일제거
            if(delFileList != null) {
                for (FileEntity f : delFileList) {
                    File dFile = new File(uploadPath, f.getFilename()+"."+f.getExtname());
                    dFile.delete();
                }
            }
            // 수정성공
            return ResponseEntity.ok().body("OK");

        }catch(Exception e){
            //
            if(newUploadFile != null){
                for(FileEntity del: newUploadFile){
                    File f = new File(uploadPath, del.getFilename()+"."+del.getExtname());
                    f.delete();
                }
            }
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return ResponseEntity.status(500).body("Failed");
    }
    // 자료실 글 삭제 : 원글, 첨부파일 레코드 삭제, 첨부파일 삭제
    @GetMapping("/dataDelete/{id}")
    @Transactional(rollbackFor = {RuntimeException.class, SQLException.class})
    public ResponseEntity<String> dataDelete(@PathVariable("id") Integer id, HttpSession session){
        String path = session.getServletContext().getRealPath("/uploads");
        try {
            //DB의 해당 글에 첨부된 파일의 정보를 선택한다. 파일 삭제시 필요함.
            List<FileEntity> orgFileList = dataService.fileSelect(id);
            System.out.println("첨부된 파일 수 : "+orgFileList.size());

            // 원글 레코드 삭제
            dataService.dataDelete(id);

            // 파일 삭제
            for(FileEntity file : orgFileList){
                File f = new File(path, file.getFilename()+"."+file.getExtname());
                f.delete();
            }
            return  ResponseEntity.ok("Ok");
        }catch (Exception e){
            // 롤백
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseEntity.status(500).body("Failed");
        }
    }


}
