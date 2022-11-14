package com.helpshift.logger.database;

import com.helpshift.logger.model.LogModel;
import java.util.List;

public interface LogStorage {
    void deleteAll();

    List<LogModel> getAll();

    void insert(LogModel logModel);
}
