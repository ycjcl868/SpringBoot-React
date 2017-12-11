import React, { Component } from 'react';
import { Row, Col } from 'antd';
import LoginModal from '../LoginModal/LoginModal';

import './Header.less';

class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      visible: false,
    };
  }
  handleCancel = () => {
    this.setState({
      visible: false,
    });
  }
  handleLogin = () => {
    this.setState({
      visible: true,
    });
  }
  render() {
    const { username } = this.props;
    return (
      <div className="header">
        <Row className="header-row" type="flex" justify="end">
          <Col className="header-col">
            {username ? <p>欢迎{username}</p> :
            <div>
              <a onClick={this.handleLogin}>登录</a>
              <a onClick={this.handleLogin}>注册</a>
            </div>
            }

          </Col>
        </Row>
        <LoginModal {...this.props} visible={this.state.visible} handleCancel={this.handleCancel} />
      </div>
    );
  }
}

export default Header;
