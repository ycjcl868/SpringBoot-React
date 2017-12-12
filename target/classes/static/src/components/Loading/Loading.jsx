import React, { Component } from 'react';
import { Spin } from 'antd';
import './Loading.less';

class Loading extends Component {
  render() {
    return (<div className="spin-loading">
      <Spin className="spin-loading-content" size="large" />
    </div>);
  }
}

export default Loading;
