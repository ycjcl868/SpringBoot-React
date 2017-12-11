import React, { Component } from 'react';
import moment from 'moment';
import { Row, Col, Card, Icon, Avatar } from 'antd';

import './MovieBox.less';

const { Meta } = Card;

class MovieBox extends Component {
  render() {
    const { goodsName, author, thumbnail, saleNum, price, number, time } = this.props;
    return (
      <div className="movie-card-wrapper">
        <Card
          className="movie-card"
          cover={<img alt="movie-img" src={thumbnail} />}
        >
          <Meta
            className="movie-meta"
            title={<div>
                <h5 className="movie-title">{goodsName}</h5>
                <Row type="flex" justify="center">
                  <Col span={12}>
                    <p className="movie-time">时间：{moment(time).format('YYYY-MM-DD')}</p>
                  </Col>
                  <Col span={12}>
                    <p className="movie-author">主演：{author}</p>
                  </Col>
                </Row>
              </div>}
            description={
            <Row className="movie-meta-desc" type="flex" justify="center">
              <Col span={8}>票价：<span className="movie-star">{price}</span></Col>
              <Col span={8}>评分：<span className="movie-star">{number}</span></Col>
              <Col span={8}>人数：<span className="movie-star">{saleNum}</span></Col>
            </Row>}
          />
        </Card>
      </div>
    );
  }
}

export default MovieBox;
