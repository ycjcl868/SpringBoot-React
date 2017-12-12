import React, { Component } from 'react';

import { Row, Col, Carousel } from 'antd';

import './Banner.less';

class Banner extends Component {
  render() {
    return (
      <div className="banner">
        <div className="banner-wrapper">
          <Carousel className="banner-carousel" autoplay>
            <div className="banner-bg" style={{ background: `url(http://7xi72v.com1.z0.glb.clouddn.com/17-12-11/98029039.jpg)` }}></div>
          </Carousel>
        </div>
      </div>
    );
  }
}

export default Banner;
