在 SpringBoot 中，配置完数据库基本信息之后，就有了一个 JdbcTemplate 了，这个东西是从哪里来的呢？
源码在 org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration 类中

从这个类中，大致可以看出，当当前类路径下存在 DataSource 和 JdbcTemplate 时，该类就会被自动配置，
jdbcTemplate 方法则表示，如果开发者没有自己提供一个 JdbcOperations 的实例的话，
系统就自动配置一个 JdbcTemplate Bean（JdbcTemplate 是 JdbcOperations 接口的一个实现）
