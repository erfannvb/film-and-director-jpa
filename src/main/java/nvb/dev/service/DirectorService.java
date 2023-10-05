package nvb.dev.service;

import nvb.dev.base.service.BaseService;
import nvb.dev.entity.Director;

public interface DirectorService extends BaseService<Long, Director> {

    void register(Director director);

}
