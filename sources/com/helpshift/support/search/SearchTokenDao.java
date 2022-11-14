package com.helpshift.support.search;

import java.util.List;

public interface SearchTokenDao {
    void clear();

    SearchTokenDto get(String str);

    void save(List<SearchTokenDto> list);
}
