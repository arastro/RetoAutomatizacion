package com.gorest.utils.enums;

/*enun con lista de peticiones*/
public enum RestService {

    BASE_URL("https://gorest.co.in"),
    CREATE_USER("/public-api/users");

    private String uri;

    RestService(String uri){
        this.uri=uri;
    }

    @Override
    public String toString(){
        return uri;
    }
}
