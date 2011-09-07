package com.alibaba.druid.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

public class DruidDataSourceC3P0Adapter implements DataSource, DruidDataSourceC3P0AdapterMBean {

    private DruidDataSource dataSource;

    public DruidDataSourceC3P0Adapter(){
        dataSource = new DruidDataSource();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return dataSource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        dataSource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        dataSource.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return dataSource.getLoginTimeout();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface == DruidDataSourceC3P0Adapter.class) {
            return (T) this;
        }

        return dataSource.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        if (iface == DruidDataSourceC3P0Adapter.class) {
            return true;
        }

        return dataSource.isWrapperFor(iface);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return dataSource.getConnection(username, password);
    }

    public String getDriverClass() {
        return dataSource.getDriverClassName();
    }

    public void setDriverClass(String driverClass) {
        dataSource.setDriverClassName(driverClass);
    }

    public String getJdbcUrl() {
        return dataSource.getUrl();
    }

    public void setJdbcUrl(String jdbcUrl) {
        dataSource.setUrl(jdbcUrl);
    }

    public Properties getProperties() {
        return dataSource.getConnectProperties();
    }

    public void setProperties(Properties properties) {
        dataSource.setConnectProperties(properties);
    }

    public String getUser() {
        return dataSource.getUsername();
    }

    public void setUser(String user) {
        dataSource.setUsername(user);
    }

    public String getPassword() {
        return dataSource.getPassword();
    }

    public void setPassword(String password) {
        dataSource.setPassword(password);
    }

    public int getCheckoutTimeout() {
        return (int) dataSource.getMaxWait() / 1000;
    }

    public void setCheckoutTimeout(int checkoutTimeout) {
        dataSource.setMaxWait(checkoutTimeout * 1000);
    }

    public boolean isAutoCommitOnClose() {
        return dataSource.isDefaultAutoCommit();
    }

    public void setAutoCommitOnClose(boolean autoCommitOnClose) {
        this.dataSource.setDefaultAutoCommit(autoCommitOnClose);
    }

    public int getIdleConnectionTestPeriod() {
        return (int) (dataSource.getTimeBetweenEvictionRunsMillis() / 1000);
    }

    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        dataSource.setTimeBetweenEvictionRunsMillis(((long) idleConnectionTestPeriod) * 1000L);
    }

    public int getInitialPoolSize() {
        return dataSource.getInitialSize();
    }

    public void setInitialPoolSize(int initialPoolSize) {
        dataSource.setInitialSize(initialPoolSize);
    }

    public int getMaxIdleTime() {
        return (int) dataSource.getMinEvictableIdleTimeMillis() / 1000;
    }

    public void setMaxIdleTime(int maxIdleTime) {
        dataSource.setMinEvictableIdleTimeMillis(((long) maxIdleTime) * 1000L);
    }

    public int getMaxPoolSize() {
        return dataSource.getMaxActive();
    }

    public void setMaxPoolSize(int maxPoolSize) {
        dataSource.setMaxActive(maxPoolSize);
    }

    public int getMinPoolSize() {
        return dataSource.getMinIdle();
    }

    public void setMinPoolSize(int minPoolSize) {
        dataSource.setMinIdle(minPoolSize);
    }

    public boolean isTestConnectionOnCheckout() {
        return dataSource.isTestOnBorrow();
    }

    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
        dataSource.setTestOnBorrow(testConnectionOnCheckout);
    }

    public boolean isTestConnectionOnCheckin() {
        return dataSource.isTestOnReturn();
    }

    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
        dataSource.setTestOnReturn(testConnectionOnCheckin);
    }

    public String getPreferredTestQuery() {
        return dataSource.getValidationQuery();
    }

    public void setPreferredTestQuery(String preferredTestQuery) {
        dataSource.setValidationQuery(preferredTestQuery);
    }

    public String getDataSourceName() {
        return dataSource.getName();
    }

    public int getNumConnections() {
        return dataSource.getActiveCount() + dataSource.getPoolingCount();
    }

    public int getNumIdleConnections() {
        return dataSource.getPoolingCount();
    }

    public int getNumBusyConnections() {
        return dataSource.getActiveCount();
    }

    public int getNumUnclosedOrphanedConnections() {
        return 0;
    }

    public int getNumConnectionsDefaultUser() {
        return getNumConnections();
    }

    public int getNumIdleConnectionsDefaultUser() {
        return getNumIdleConnections();
    }

    public int getNumBusyConnectionsDefaultUser() {
        return getNumBusyConnections();
    }

    public int getMaxStatementsPerConnection() {
        return dataSource.getMaxPoolPreparedStatementPerConnectionSize();
    }

    public void setMaxStatementsPerConnection(int maxStatementsPerConnection) {
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxStatementsPerConnection);
    }

    public int getMaxStatements() {
        return dataSource.getMaxOpenPreparedStatements();
    }

    public void setMaxStatements(int maxStatements) {
        dataSource.setMaxOpenPreparedStatements(maxStatements);
    }

    public int getUnreturnedConnectionTimeout() {
        return dataSource.getRemoveAbandonedTimeout();
    }

    public void setUnreturnedConnectionTimeout(int unreturnedConnectionTimeout) {
        dataSource.setRemoveAbandonedTimeout(unreturnedConnectionTimeout);
    }

    public boolean isDebugUnreturnedConnectionStackTraces() {
        return dataSource.isLogAbandoned();
    }

    public void setDebugUnreturnedConnectionStackTraces(boolean debugUnreturnedConnectionStackTraces) {
        dataSource.setLogAbandoned(debugUnreturnedConnectionStackTraces);
    }

    public int getAcquireRetryAttempts() {
        return dataSource.getConnectionErrorRetryAttempts();
    }

    public void setAcquireRetryAttempts(int acquireRetryAttempts) {
        dataSource.setConnectionErrorRetryAttempts(acquireRetryAttempts);
    }

    public int getAcquireRetryDelay() {
        return (int) (dataSource.getTimeBetweenConnectErrorMillis() / 1000L);
    }

    public void setAcquireRetryDelay(int acquireRetryDelay) {
        dataSource.setTimeBetweenConnectErrorMillis(((long) acquireRetryDelay) * 1000);
    }

    // /////////////////

    @Override
    public boolean isEnable() {
        return dataSource.isEnable();
    }

    @Override
    public void shrink() {
        dataSource.shrink();
    }

    @Override
    public int getWaitThreadCount() {
        return dataSource.getWaitThreadCount();
    }

    @Override
    public int getLockQueueLength() {
        return dataSource.getLockQueueLength();
    }

    @Override
    public void close() {
        dataSource.close();
    }

    // ///////////////

    private String  overrideDefaultUser;
    private String  overrideDefaultPassword;
    private int     propertyCycle;
    private boolean breakAfterAcquireFailure;
    private boolean usesTraditionalReflectiveProxies;
    private String  userOverridesAsString;
    private int     maxAdministrativeTaskTime;
    private int     maxIdleTimeExcessConnections;
    private int     maxConnectionAge;
    private String  connectionCustomizerClassName;
    private String  factoryClassLocation;
    private int     acquireIncrement = 1;

    private String  connectionTesterClassName;
    private String  automaticTestTable;

    public String getConnectionTesterClassName() {
        return connectionTesterClassName;
    }

    public void setConnectionTesterClassName(String connectionTesterClassName) {
        this.connectionTesterClassName = connectionTesterClassName;
    }

    public String getAutomaticTestTable() {
        return automaticTestTable;
    }

    public void setAutomaticTestTable(String automaticTestTable) {
        this.automaticTestTable = automaticTestTable;
    }

    private boolean forceIgnoreUnresolvedTransactions;

    public boolean isForceIgnoreUnresolvedTransactions() {
        return forceIgnoreUnresolvedTransactions;
    }

    public void setForceIgnoreUnresolvedTransactions(boolean forceIgnoreUnresolvedTransactions) {
        this.forceIgnoreUnresolvedTransactions = forceIgnoreUnresolvedTransactions;
    }

    public boolean isUsesTraditionalReflectiveProxies() {
        return usesTraditionalReflectiveProxies;
    }

    public void setUsesTraditionalReflectiveProxies(boolean usesTraditionalReflectiveProxies) {
        this.usesTraditionalReflectiveProxies = usesTraditionalReflectiveProxies;
    }

    public String getUserOverridesAsString() {
        return userOverridesAsString;
    }

    public void setUserOverridesAsString(String userOverridesAsString) {
        this.userOverridesAsString = userOverridesAsString;
    }

    public int getMaxAdministrativeTaskTime() {
        return maxAdministrativeTaskTime;
    }

    public void setMaxAdministrativeTaskTime(int maxAdministrativeTaskTime) {
        this.maxAdministrativeTaskTime = maxAdministrativeTaskTime;
    }

    public int getMaxIdleTimeExcessConnections() {
        return maxIdleTimeExcessConnections;
    }

    public void setMaxIdleTimeExcessConnections(int maxIdleTimeExcessConnections) {
        this.maxIdleTimeExcessConnections = maxIdleTimeExcessConnections;
    }

    public int getMaxConnectionAge() {
        return maxConnectionAge;
    }

    public void setMaxConnectionAge(int maxConnectionAge) {
        this.maxConnectionAge = maxConnectionAge;
    }

    public String getConnectionCustomizerClassName() {
        return connectionCustomizerClassName;
    }

    public void setConnectionCustomizerClassName(String connectionCustomizerClassName) {
        this.connectionCustomizerClassName = connectionCustomizerClassName;
    }

    public String getFactoryClassLocation() {
        return factoryClassLocation;
    }

    public void setFactoryClassLocation(String factoryClassLocation) {
        this.factoryClassLocation = factoryClassLocation;
    }

    public int getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(int acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

    public String getOverrideDefaultUser() {
        return overrideDefaultUser;
    }

    public void setOverrideDefaultUser(String overrideDefaultUser) {
        this.overrideDefaultUser = overrideDefaultUser;
    }

    public String getOverrideDefaultPassword() {
        return overrideDefaultPassword;
    }

    public void setOverrideDefaultPassword(String overrideDefaultPassword) {
        this.overrideDefaultPassword = overrideDefaultPassword;
    }

    public int getPropertyCycle() {
        return propertyCycle;
    }

    public void setPropertyCycle(int propertyCycle) {
        this.propertyCycle = propertyCycle;
    }

    public boolean isBreakAfterAcquireFailure() {
        return breakAfterAcquireFailure;
    }

    public void setBreakAfterAcquireFailure(boolean breakAfterAcquireFailure) {
        this.breakAfterAcquireFailure = breakAfterAcquireFailure;
    }

}
