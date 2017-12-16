module.exports = function (config, webpack) {
  config.plugins.push(new webpack.optimize.CommonsChunkPlugin({
    name: 'app',
    minChunks: Infinity,
  }));
  config.externals = [{
    'lie': 'window.Promise',
    'react': 'window.React',
    'react-dom': 'window.ReactDOM || window.React',
    'react-router': 'window.ReactRouter'
  }];
  if (process.argv[2] === 'server') {
    config.externals.push((context, request, callback, matches) => {
      if (/uxcore\/assets\//.test(request)) {
        callback(null, '0');
      } else if (matches = /uxcore$/.exec(request)) {
        callback(null, `window.Uxcore`);
      } else if (matches = /react\-addons((\-\w+)+)/.exec(request)) {
        const addon = matches[1].replace(/\-((\w)(\w+))/g, (p, p1, p2, p3) =>
          (!/^(css|dom|umd)$/.test(p1) ? p2.toUpperCase() + p3 : p1.toUpperCase())
        );
        callback(null, `window.React.addons.${addon}`);
      } else {
        callback();
      }
    });
  } else {
    config.module.loaders.forEach((n) => {
      if (/\.css/.test(n.test)) {
        delete n.include;
      } else if (/\.jsx?$/.toString() === n.test.toString()) {
        n.query.plugins.push(['import', { libraryName: 'uxcore', camel2UnderlineComponentName: false, camel2DashComponentName: false }]);
      }
    });
  }
};
