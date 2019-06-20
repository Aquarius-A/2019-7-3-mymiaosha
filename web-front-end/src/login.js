import React from 'react'
import Logo from './logo.js'
import {List,InputItem,WingBlank,WhiteSpace,Button} from 'antd-mobile'

class Login extends React.Component{
    constructor(props){
        super(props);
//绑定this时间，如果不绑定，无法传递this
        this.register = this.register.bind(this);
    }
    register(){
        console.log(this.props);
//跳转到注册页面
        this.props.history.push('./register')
    }
    render(){
        return (
            <div className="logo-container">
                <h2>我是登录页</h2>
                <Logo></Logo>
                <WingBlank>
                    <List >
                        <InputItem>用户名</InputItem>
                        <InputItem type="password">密码</InputItem>
                    </List>
                    <WhiteSpace />
                    <Button type="primary">登录</Button>
                    <WhiteSpace/>
                    <Button onClick={this.register} type="primary">注册</Button>
                </WingBlank>
            </div>
        )
    }
}

export default Login