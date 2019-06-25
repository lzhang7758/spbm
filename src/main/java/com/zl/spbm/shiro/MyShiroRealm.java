package com.zl.spbm.shiro;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.zl.spbm.entity.SysPermission;
import com.zl.spbm.entity.SysRole;
import com.zl.spbm.entity.UserInfo;
import com.zl.spbm.service.inter.ISysRoleService;
import com.zl.spbm.service.inter.IUserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Resource
    private IUserInfoService userInfoService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    Gson gson;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	logger.debug("权限配置-->MyShiroRealm.doGetAuthorizationInfo() principals={}", JSONObject.toJSONString(principals,SerializerFeature.WRITE_MAP_NULL_FEATURES));
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
        logger.debug("AuthorizationInfo doGetAuthorizationInfo=> userInfo="+gson.toJson(userInfo));
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
            	if(p.getPermission() != null ) {
            		authorizationInfo.addStringPermission(p.getPermission());
            	}
            }
        }
        logger.debug("----->>authorizationInfo="+gson.toJson(authorizationInfo));
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        logger.debug("JSONObject.toJSONString(principals,SerializerFeature.WRITE_MAP_NULL_FEATURES)");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        logger.debug("token.getCredentials()="+gson.toJson(token.getCredentials()));
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.selectUserInfoByUserName(username);
        if(userInfo == null){
            return null;
        }
        List<SysRole> roleList= new ArrayList<SysRole>();
        for(SysRole role:userInfo.getRoleList()){
        	roleList.add(sysRoleService.selectSysRoleById(role.getRoleId()));
        }
        userInfo.setRoleList(roleList);
        logger.debug("----->>userInfo="+gson.toJson(userInfo));
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

}