package com.brewduck.web.hop.service;

import com.brewduck.web.domain.Hop;

import java.util.List;


/**
 * <pre>
 * 맥주 홉 Service 인터페이스.
 * </pre>
 *
 * @author  chacha
 * @version 1.0, 2014.02.16
 */
public interface HopService {

    /**
     * <pre>
     * 맥주 홉 목록 조회.
     * </pre>
     *
     * @param hop 맥주 홉
     * @return 맥주 홉 목록
     */
    public List<Hop> selectHopList(Hop hop);

    /**
     * <pre>
     * 맥주 홉 상세 조회.
     * </pre>
     *
     * @param hop 맥주 홉
     * @return 맥주 홉 내용
     */
    public Hop selectHopDetail(Hop hop);

    /**
     * <pre>
     * 맥주 홉 저장.
     * </pre>
     *
     * @param hop 맥주 홉
     * @return 저장 성공 여부
     */
    public Boolean insertHop(Hop hop);

    /**
     * <pre>
     * 맥주 홉 수정.
     * </pre>
     *
     * @param hop 맥주 홉
     * @return 수정 성공 여부
     */
    public Boolean updateHop(Hop hop);

    /**
     * <pre>
     * 맥주 홉 삭제.
     * </pre>
     *
     * @param hop 맥주 홉
     * @return 삭제 성공 여부
     */
    public Boolean deleteHop(Hop hop);

}
