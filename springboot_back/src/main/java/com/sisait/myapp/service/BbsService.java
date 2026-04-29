package com.sisait.myapp.service;

import com.sisait.myapp.entity.BbsEntity;
import com.sisait.myapp.entity.JoinsEntity;
import com.sisait.myapp.entity.PagingVO;
import com.sisait.myapp.repository.BbsRepository;
import com.sisait.myapp.repository.JoinsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BbsService {
    private final BbsRepository bbsRepository;
    private final JoinsRepository joinsRepository;

    // 뉴스글 등록
    public BbsEntity bbsInsertOrUpdate(BbsEntity bbsEntity){
        return bbsRepository.save(bbsEntity);
    }
    // 총레코드수
    public int bbsTotalRecord(PagingVO pVO){
        if(pVO.getSearchWord() == null || pVO.getSearchWord()==null){ //검색어가 없을 때
            return bbsRepository.countIdBy();
        }else{ // 검색어가 있을때
            if(pVO.getSearchKey().equals("subject")){ // 제목검색
               return bbsRepository.countIdBySubjectContaining(pVO.getSearchWord());
            }else if(pVO.getSearchKey().equals("content")){ // 내용에서 검색
                return bbsRepository.countIdByContentContaining(pVO.getSearchWord());
            }else{ // 글쓴이 검색
                return bbsRepository.countIdByJoinsEntity_IdIn(joins_idList(pVO.getSearchWord()));
            }
        }

    }
    // 레코드 선택
    public List<BbsEntity> bbsList(){
        // select * from bbs_entity order by bbs_id desc;
        List<BbsEntity> list =  bbsRepository.findAllByOrderByIdDesc();
        return list;
    }
    // 레코드 선택 : paging정보가 있을 때
    public List<BbsEntity> bbsList(PagingVO pVO){
        // page 정보는 있고 검색어는 없을 때
        // jpa메소드의 매개변수에 페이지 관련정보를 표기한다.
        // 컨트롤러 매핑에 @PageableDefault를 기술하고, 매개변수에 PageRequest를 정의한다.
        // 선택할 페이지(0,1,2,3,4,..) 1페이지당 선택할 레코드 수

        // select * from bbs_entity where subject like '%링컨%'

        List<BbsEntity> resultEntity = null;
        // 1. 검색어가 없을 때
        if(pVO.getSearchKey() == null || pVO.getSearchWord() == null) {
            resultEntity =  bbsRepository.findAllByOrderByIdDesc(PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
        }else{// 2. 검색어가 있을 떄

            if(pVO.getSearchKey().equals("subject")){// 제목에서 검색
                resultEntity = bbsRepository.findBySubjectContainingOrderByIdDesc(pVO.getSearchWord(),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }else if(pVO.getSearchKey().equals("content")){// 글 내용에서 검색
                resultEntity = bbsRepository.findByContentContainingOrderByIdDesc(pVO.getSearchWord(),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
            }else{// 작성자에서 검색
                resultEntity = bbsRepository.findByJoinsEntity_IdInOrderByIdDesc(joins_idList(pVO.getSearchWord()),PageRequest.of(pVO.getNowPage() - 1, pVO.getOnePageRecord()));
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
        public Optional<BbsEntity> bbsSelect(Integer id){
            return bbsRepository.findById(id);

        }
        // 조회수 증가
        public void bbsHitCount(Integer id){
            // 해당글 선택
            //Optional<BbsEntity> bbsEntity = bbsSelect(id);
            // hit의 값을 1 증가
            //bbsEntity.get().setHit(bbsEntity.get().getHit()+1);
            // update 수행( save()=> Entity담긴 데이터)
            //bbsRepository.save(bbsEntity.get());
            bbsRepository.bbsHitCount(id);
        }
        // 글 삭제,
        public int bbsDelete(int id){
            return bbsRepository.bbsDelete(id);
        }
}
