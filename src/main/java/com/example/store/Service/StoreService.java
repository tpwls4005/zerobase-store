package com.example.store.Service;

import com.example.store.Model.Store;
import com.example.store.Repository.StoreRepository;
import com.example.store.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public void registerStore(StoreDTO storeDTO) {
        // StoreDTO를 Store 엔티티로 변환 후 저장
        Store store = new Store();
        store.setName(storeDTO.getName());
        store.setAddress(storeDTO.getAddress());
        // 필요한 다른 정보 설정

        storeRepository.save(store);
    }

    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }

    // 다른 매장 관련 서비스 메서드들 추가 가능
}
