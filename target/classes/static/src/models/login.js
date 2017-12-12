import { get, post } from '../services/common';
import { message } from 'antd';
export default {

  namespace: 'login',

  state: {
    username: '',
  },
  effects: {
    * login({ payload, success }, { call, put }) {
      const { data } = yield call(post, '/api/user/login', `email=${payload.email}&pwd=${payload.pwd}`);
      if (data.rtCode === '0') {
        message.success(`登录成功, 用户名：${data.data.email}`);
        yield put({
          type: 'updateState',
          payload: {
            username: data.data.email,
          },
        });
        if (success) {
          success();
        }
      } else {
        message.error(data.rtMsg);
      }
    },
  },

  reducers: {
    updateState(state, { payload }) {
      return { ...state, ...payload };
    },
  },

};
