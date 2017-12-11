import React, { Component } from 'react';

import { Modal, Button, Form, Icon, Input, message } from 'antd';

import './LoginModal.less';

const FormItem = Form.Item;

class LoginModal extends Component {
  constructor(props) {
    super(props);
  }
  handleSubmit = (e) => {
    e.preventDefault();
    const { dispatch, handleCancel } = this.props;
    this.props.form.validateFields((err, values) => {
      if (err) return;
      console.log('Received values of form: ', values);
      dispatch({
        type: 'login/login',
        payload: {
          ...values,
        },
        success: () => {
          handleCancel();
        },
      });
    });
  }
  render() {
    const { handleCancel, visible, form } = this.props;
    const { getFieldDecorator } = form;
    return (
      <div>
        <Modal
          title="登录"
          onCancel={handleCancel}
          visible={visible}
          footer={[
            <Button key="submit" type="primary" onClick={this.handleSubmit}>提交</Button>,
            <Button key="back" type="ghost" onClick={handleCancel}>取消</Button>
          ]}
        >
          <Form onSubmit={this.handleSubmit} className="login-form">
            <FormItem>
              {getFieldDecorator('email', {
                rules: [{ required: true, message: '请输入用户名' }],
              })(
                <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="用户名" />
              )}
            </FormItem>
            <FormItem>
              {getFieldDecorator('pwd', {
                rules: [{ required: true, message: '请输入密码' }],
              })(
                <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="请输入密码" />
              )}
            </FormItem>
          </Form>
        </Modal>
      </div>
    );
  }
}

export default Form.create()(LoginModal);
