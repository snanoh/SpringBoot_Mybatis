package com.hancom.persistence;

import com.hancom.entity.Board;
import org.springframework.stereotype.Repository;

@Repository
public interface Board_DAO {
    void saveBoard(Board board);
}
