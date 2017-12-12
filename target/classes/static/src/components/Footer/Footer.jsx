import React, { Component } from 'react';

import { Row, Col } from 'antd';

import './Footer.less';

class Footer extends Component {
  render() {
    return (
      <div className="footer">
        <div className="footer-wrapper">
          <Row className="contact">
            <Col span={8}>
              <h5>联系我们</h5>
              <p>chaolinjin@gmail.com</p>
            </Col>
          </Row>
          <Row className="copyright">
            <p>信鑫-King © 2017 基础资源和备案服务由阿里云提供</p>
          </Row>
        </div>
      </div>
    );
  }
}

export default Footer;
