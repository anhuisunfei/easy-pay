package com.payment.module.sys.esrepository;

import com.payment.module.sys.model.UserModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * es 仓储
 *
 * @author sunfei
 * @version 1.0
 * @date 2020/12/10 20:39
 */
@Repository
public interface EsUserRepository extends ElasticsearchRepository<UserModel, Long> {
}
