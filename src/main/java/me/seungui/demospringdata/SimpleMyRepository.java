package me.seungui.demospringdata;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class SimpleMyRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

  private EntityManager entityManger;

  public SimpleMyRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManger = entityManager;
  }

  @Override
  public boolean contains(T entity) {
    return entityManger.contains(entity);
  }
}
