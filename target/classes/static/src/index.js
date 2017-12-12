import ReactDOM from 'react-dom';
import React from 'react';
import dva from 'dva';
import createLoading from 'dva-loading';
import './index.less';

// 1. Initialize
const app = dva();

// 2. Plugins
app.use(createLoading({ effects: true }));

// 3. Model autoMount
require.context('./models', true, /\.js$/).keys().forEach((file) => {
  app.model(require(`./models/${file.slice(2)}`));
});

// 4. Router
app.router(require('./router'));
const App = app.start();

// 5. Start

ReactDOM.render(
  <App />,
  document.getElementById('root'),
);
