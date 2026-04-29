package com.sisait.myapp.service;

import com.sisait.myapp.entity.*;
import com.sisait.myapp.repository.DataRepository;
import com.sisait.myapp.repository.FileRepository;
import com.sisait.myapp.repository.JoinsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataService {
    private final DataRepository dataRepository;
    private final FileRepository fileRepository;
    private final JoinsRepository joinsRepository;
    private final JoinsService joinsService;
    // 자료실 원글 등록
    public DataEntity dataInsert(DataEntity dataEntity){
        return dataRepository.save(dataEntity);
    }
    // 파일 등록,자료실 수정에서 새로 업로드한 파일이 있을때 레코드 추가
    public int fileListInsert(List<FileEntity> fileList){
        int cnt =0;
        for(FileEntity entity : fileList) {
            fileRepository.save(entity);
            cnt++;
        }
        return cnt;
    }
    // 총 레코드수
    public int dataTotalRecord(PagingVO pVO){
        if(pVO.getSearchWord() == null || pVO.getSearchWord()==null){ //검색어가 없을 때
            return dataRepository.countIdBy();
        }else{ // 검색어가 있을때
            if(pVO.getSearchKey().equals("subject")){ // 제목검색
                return dataRepository.countIdBySubjectContaining(pVO.getSearchWord());
            }else if(pVO.getSearchKey().equals("content")){ // 내용에서 검색
                return dataRepository.countIdByContentContaining(pVO.getSearchWord());
            }else{ // 글쓴이 검색
                return dataRepository.countIdByJoinsEntity_IdIn(joins_idList(pVO.getSearchWord()));
            }
        }
    }
    // 글쓴이 이름으로 joins_id를 리스트로 얻어오는 메소드
    public List<Integer> joins_idList(String username){
        List<JoinsEntity> entity = joinsRepository.findByUsername(username);

        List<Integer> idList = new ArrayList<Integer>();
        for(int i = 0 ; i<entity.size();i++){
            idList.add(entity.get(i).getId());
        }
        return idList;
    }
    // 레코드 선택 : paging정보가 있을 때
    public List<DataEntity> dataList(PagingVO pVO){
        // select * from bbs_entity where subject like '%링컨%'

        List<DataEntity> resultEntity = null;
        // 1. 검색어가 없을 때
        if(pVO.getSearchKey() == null || pVO.getSearchWord() == null) {
            resultEntity =  dataRepository.findAllByOrderByIdDesc(PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
        }else{// 2. 검색어가 있을 떄

            if(pVO.getSearchKey().equals("subject")){// 제목에서 검색
                resultEntity = dataRepository.findBySubjectContainingOrderByIdDesc(pVO.getSearchWord(),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }else if(pVO.getSearchKey().equals("content")){// 글 내용에서 검색
                resultEntity = dataRepository.findByContentContainingOrderByIdDesc(pVO.getSearchWord(),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }else{// 작성자에서 검색
                resultEntity = dataRepository.findByJoinsEntity_IdInOrderByIdDesc(joins_idList(pVO.getSearchWord()),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }


        }
        return resultEntity;

    }
    //해당레코드 선택
    public Optional<DataEntity> dataSelect(int id){

        return dataRepository.findById(id);
    }
    // 조회수 증가
    public void hitCount(int id){
        dataRepository.hitCount(id);
    }
    //첨부파일 선택
    public List<FileEntity> fileSelect(int id){
        return fileRepository.findByDataEntity_id(id);
    }
    public int dataUpdate(DataEntity dataEntity){
        return dataRepository.dataUpdate(dataEntity.getId(), dataEntity.getSubject(), dataEntity.getContent());
    }

    //FileEntity에서 id를 이용하여 해당레코드 선택하기
    public List<FileEntity> fileIdSelect(List<Integer> delFile){
        return fileRepository.findByIdIn(delFile);
    }

    public int fileDelete(List<Integer> delFile){
        return fileRepository.deleteByIdIn(delFile);
    }
    // 해당글의 FileEntity삭제:원글 번호를 기준으로 삭제
    public List<FileEntity> fileListDelete(Integer id){
        return fileRepository.findByDataEntity_id(id);
    }
    // 원글 삭제
    public void dataDelete(Integer id ){
        DataEntity entity = dataRepository.findById(id)
                .orElseThrow(()->new RuntimeException("해당 글이 없습니다."));
        dataRepository.delete(entity);
    }
}
