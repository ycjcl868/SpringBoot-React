import React, { Component } from 'react';

import { Row, Col } from 'antd';

import MovieBox from '../MovieBox/MovieBox';

import './Movie.less';

class Movie extends Component {
  render() {
    const { goods } = this.props;
    return (
      <div className="movie">
        <div className="movie-wrapper">
          <Row type="flex" gutter={16}>
            {goods && goods.length > 0 && goods.map(item =>
              <Col key={item.id} sm={6} xs={8}>
                <MovieBox {...item} />
              </Col>
            )}
          </Row>
        </div>
      </div>
    );
  }
}

export default Movie;
