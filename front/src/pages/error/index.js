
export default {
  path: '*',
  title: 'error',
  getComponent(nextState, cb) {
    require.ensure([], (require) => {
      cb(null, require('./PageError'));
    }, 'error');
  },
};


