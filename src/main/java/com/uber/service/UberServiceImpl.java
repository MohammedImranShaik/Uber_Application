package com.uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uber.dto.UberDTO;
import com.uber.entity.RoleJpaRepository;
import com.uber.entity.UberEntity;
import com.uber.repository.UberJpaRepository;
import com.uber.util.AppModelMapper;

@Service
public class UberServiceImpl implements UberService {

	@Autowired
	private UberJpaRepository uberJpaRepository;

	@Autowired
	private AppModelMapper appModelMapper;

	@Autowired
	private RoleJpaRepository roleJpaRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUber(UberDTO uberDTO) {

		String encryptedPwd = passwordEncoder.encode(uberDTO.getPassword());
		uberDTO.setPassword(encryptedPwd);

		UberEntity uberEntity = appModelMapper.dtoToEntity(uberDTO);
		uberJpaRepository.save(uberEntity);

	}

	@Override
	public Boolean findByEmail(String email) {
		UberEntity uberEntity = uberJpaRepository.findByEmail(email);
		if (uberEntity != null) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UberEntity uberEntity = uberJpaRepository.findByEmail(username);
			if(null == uberEntity) {
				throw new UsernameNotFoundException("Invalid Credentials...");
			}
		
		return User.withUsername(uberEntity.getEmail()).password(uberEntity.getPassword()).build();

	}

}
