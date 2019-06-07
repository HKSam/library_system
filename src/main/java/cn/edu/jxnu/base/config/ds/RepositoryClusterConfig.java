package cn.edu.jxnu.base.config.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 从数据源配置

 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryCluster", transactionManagerRef = "transactionManagerCluster", basePackages = {
		"cn.edu.jxnu.base.dao" })
public class RepositoryClusterConfig {
	/**
	 * JPA属性
	 */
	@Autowired
	private JpaProperties jpaProperties;

	/**
	 * 数据源
	 */
	@Autowired
	@Qualifier("cluster")
	private DataSource cluster;

	/**
	 * 实体管理器

	 */
	@Bean(name = "entityManagerCluster")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactorySecondary(builder).getObject().createEntityManager();
	}

	/**
	 * 实体管理器工厂

	 */
	@Bean(name = "entityManagerFactoryCluster")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(cluster).properties(getVendorProperties(cluster)).packages("cn.edu.jxnu.base.entity")
				.persistenceUnit("clusterPersistenceUnit").build();
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}

	/**
	 * 事务管理器
	 *
	 */
	@Bean(name = "transactionManagerCluster")
	PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
	}

}