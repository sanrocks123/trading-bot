package sanrocks.tradingbot.repository;

import sanrocks.tradingbot.domain.ProductQuoteEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQuoteEventRepository extends MongoRepository<ProductQuoteEvent, String> {
}
