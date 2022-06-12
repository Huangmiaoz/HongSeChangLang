package com.service.impl;

import com.entity.Thing;
import com.mapper.ThingMapper;
import com.service.ThingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ……hyy……
 * @since 2022-06-08
 */
@Service
public class ThingServiceImpl extends ServiceImpl<ThingMapper, Thing> implements ThingService {

}
