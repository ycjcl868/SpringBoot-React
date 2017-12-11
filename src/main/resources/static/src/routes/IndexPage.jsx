import React, { Component } from 'react';
import { connect } from 'dva';
import './IndexPage.less';


import Loading from '../components/Loading/Loading';
import Header from '../components/Header/Header';
import Banner from '../components/Banner/Banner';
import Movie from '../components/Movie/Movie';
import Footer from '../components/Footer/Footer';

class IndexPage extends Component {
  static propTypes = {

  }
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: 'index/getNews',
    });
  }
  render() {
    const { index } = this.props.loading;
    return (
      <div className="wrapper">
        {!index ?
          <div>
            <Header {...this.props} />
            <Banner />
            <Movie {...this.props} />
            <Footer />
          </div> :
          <Loading />
        }
      </div>
    );
  }
}

export default connect((state) => ({
  goods: state.index.goods,
  loading: state.loading.models,
  username: state.login.username,
}))(IndexPage);
