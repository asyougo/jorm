package com.liang.proxy;

import java.lang.reflect.Proxy;

public class ProxyGenerator<T, DAO> {
    private TemplateDao<T> templateDao;
    public ProxyGenerator(TemplateDao<T> templateDao) {
        this.templateDao = templateDao;
    }

    public DAO getProxy(Class<DAO> daoInterface, Class<T> modelClass){
        return (DAO) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{daoInterface}, (proxy, method, args) -> {
            switch (method.getName()) {
                case "put":
                    return templateDao.put((T) args[0], modelClass);
                case "get":
                    return null;
            }
            return null;
        });
    }
}
