package com.sisait.myapp.service;


import com.sisait.myapp.entity.JoinsEntity;
import com.sisait.myapp.entity.PagingVO;
import com.sisait.myapp.entity.QnaEntity;

import com.sisait.myapp.repository.JoinsRepository;
import com.sisait.myapp.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaRepository qnaRepository;
    private final JoinsRepository joinsRepository;

    // 뉴스글 등록
    public QnaEntity qnaInsertOrUpdate(QnaEntity qnaEntity){
        return qnaRepository.save(qnaEntity);
    }
    // 총레코드수
    public int qnaTotalRecord(PagingVO pVO){
        if(pVO.getSearchWord() == null || pVO.getSearchWord()==null){ //검색어가 없을 때
            return qnaRepository.countIdBy();
        }else{ // 검색어가 있을때
            if(pVO.getSearchKey().equals("subject")){ // 제목검색
                return qnaRepository.countIdBySubjectContaining(pVO.getSearchWord());
            }else if(pVO.getSearchKey().equals("content")){ // 내용에서 검색
                return qnaRepository.countIdByContentContaining(pVO.getSearchWord());
            }else{ // 글쓴이 검색
                return qnaRepository.countIdByJoinsEntity_IdIn(joins_idList(pVO.getSearchWord()));
            }
        }

    }
    // 레코드 선택
    public List<QnaEntity> qnaList(){

        List<QnaEntity> list =  qnaRepository.findAllByOrderByIdDesc();
        return list;
    }
    // 레코드 선택 : paging정보가 있을 때
    public List<QnaEntity> qnaList(PagingVO pVO){

        List<QnaEntity> resultEntity = null;
        // 1. 검색어가 없을 때
        if(pVO.getSearchKey() == null || pVO.getSearchWord() == null) {
            resultEntity =  qnaRepository.findAllByOrderByIdDesc(PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
        }else{// 2. 검색어가 있을 떄

            if(pVO.getSearchKey().equals("subject")){// 제목에서 검색
                resultEntity = qnaRepository.findBySubjectContainingOrderByIdDesc(pVO.getSearchWord(),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }else if(pVO.getSearchKey().equals("content")){// 글 내용에서 검색
                resultEntity = qnaRepository.findByContentContainingOrderByIdDesc(pVO.getSearchWord(),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }else{// 작성자에서 검색
                resultEntity = qnaRepository.findByJoinsEntity_IdInOrderByIdDesc(joins_idList(pVO.getSearchWord()),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }


        }
        return resultEntity;

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
    // 레코드 선택(글내용보기)
    public Optional<QnaEntity> qnaSelect(Integer id){
        return qnaRepository.findById(id);

    }
    // 조회수 증가
    public void qnaHitCount(Integer id){

        qnaRepository.qnaHitCount(id);
    }
    // 글 삭제,
    public int qnaDelete(int id){
        return qnaRepository.qnaDelete(id);
    }
}
