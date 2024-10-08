package com.example.tobi.springtobi.ch05.ex_5_2.service;



import com.example.tobi.springtobi.ch05.ex_5_2.dao.UserDao;
import com.example.tobi.springtobi.ch05.ex_5_2.domain.Level;
import com.example.tobi.springtobi.ch05.ex_5_2.domain.User;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCMMEND_FOR_GORD = 30;

    private UserDao userDao;
    private DataSource dataSource;
    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public UserService(String id) {}

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) {
        if(user.getLevel()==null){
            user.setLevel(Level.BASIC);
        }

        userDao.add(user);
    }

    public void upgradeLevels(){
        List<User> users = userDao.getAll();

         for (User user : users) {
             if(canUpgradeLevel(user)){
                 // upgrade
                 upgradeLevel(user);
             }
         }
    }

    public void upgradeLevelsV2() throws SQLException {

        TransactionSynchronizationManager.initSynchronization();
        Connection c = DataSourceUtils.getConnection(dataSource);

        c.setAutoCommit(false);
        try{
            List<User> users = userDao.getAll();

            for (User user : users) {
                if(canUpgradeLevel(user)){
                    // upgrade
                    upgradeLevel(user);
                }
            }
            c.commit();
        }catch (Exception e){
            c.rollback();
            throw e;
        }finally {
            DataSourceUtils.releaseConnection(c, dataSource);
            TransactionSynchronizationManager.unbindResource(dataSource);
            TransactionSynchronizationManager.clearSynchronization();
        }
    }

    public void upgradeLevelsV3() throws SQLException {

        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            List<User> users = userDao.getAll();

            for (User user : users) {
                if(canUpgradeLevel(user)){
                    // upgrade
                    upgradeLevel(user);
                }
            }
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
            throw e;
        }finally {

        }
    }
    public void upgradeLevelsV4() throws SQLException {

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            List<User> users = userDao.getAll();

            for (User user : users) {
                if(canUpgradeLevel(user)){
                    // upgrade
                    upgradeLevel(user);
                }
            }
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
            throw e;
        }finally {

        }
    }
    private boolean canUpgradeLevel(User user){
        Level currentLevel = user.getLevel();

        switch (currentLevel){
            case BASIC:
                return (user.getLogin()>=MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend()>=MIN_RECCMMEND_FOR_GORD);
            case GOLD:
                return false;
            default:
                throw new IllegalArgumentException("Unexpected level: " + currentLevel);
        }
    }

    protected void upgradeLevel(User user){
        user.upgradeLevel();
        userDao.update(user);
    }

    static class TestUserService extends UserService{

        private String id;

        public TestUserService(String id) {
            super(id);
            this.id = id;
        }

        @Override
        public void upgradeLevel(User user) {
            if( user.getId().equals(id)){
                throw new TestUserServiceException();
            }
            super.upgradeLevel(user);
        }
    }

    static class TestUserServiceException extends RuntimeException {}
}
