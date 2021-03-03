package com.example.content.controller;


import com.example.content.entity.Share;
import com.example.content.entity.dto.ShareDto;
import com.example.content.entity.dto.UserDto;
import com.example.content.service.ShareService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.ws.Response;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ChaosBear
 * @since 2021-03-03
 */
@RestController
@RequestMapping("/content/share")
public class ShareController {
    @Autowired
    ShareService shareService;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ShareDto getShareById(@PathVariable Integer id){
        Share share = shareService.getShareById(id);
      //  RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> userDto = restTemplate.getForEntity(
                "http://localhost:8081/user/{id}",
                UserDto.class,
                share.getUserId()
        );
        ShareDto shareDto = new ShareDto();
        BeanUtils.copyProperties(share,shareDto);
        shareDto.setWxNickname(userDto.getBody().getWxNickname());

        return shareDto;
    }


}
