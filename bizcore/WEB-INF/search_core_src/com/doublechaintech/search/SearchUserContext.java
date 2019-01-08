package com.doublechaintech.search;

public interface SearchUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(SearchChecker checker);
	SearchChecker getChecker();
}

