const webpack = require('webpack');
const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

const LINK_PREFIX = 'https://frontend-cloud-s3.s3.amazonaws.com/angularjs/';

const Mode = {
    Development: 'development',
    Production: 'production',
};

module.exports = (env, argv) => ({
    entry: {
        main: path.resolve(__dirname, 'src', 'main.ts')
    },
    output: {
        filename: '[name].bundle.[hash:4].js',
        path: path.resolve(__dirname, 'dist'),
        publicPath: argv.mode === Mode.Production ? LINK_PREFIX : '/',
    },
    devtool: 'inline-source-map',
    module: {
        rules: [{
            test: /\.ts$/,
            use: [{
                loader: 'ng-annotate-loader',
                options: { ngAnnotate: 'ng-annotate-patched', sourcemap: true }
            }, {
                loader: 'ts-loader'
            }],
            exclude: /node_modules/
        }, {
            test: /\.css$/,
            use: [MiniCssExtractPlugin.loader, 'css-loader', 'resolve-url-loader']
        }, {
            test: /\.scss$/,
            use: [MiniCssExtractPlugin.loader, 'css-loader', 'resolve-url-loader', 'sass-loader']
        }, {
            test: /\.html$/,
            loader: 'html-loader'
        }]
    },
    resolve: {
        extensions: ['.ts', '.js', '.json'],
        modules: [path.resolve(__dirname, 'src'), 'node_modules'],
    },
    plugins: [
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: path.resolve(__dirname, 'src', 'index.html'),
        }),
        new MiniCssExtractPlugin({
            filename: '[name].[contenthash:4].css',
            chunkFilename: '[id].[contenthash:4].css'
        }),
        new CleanWebpackPlugin(),
        // new webpack.SourceMapDevToolPlugin({
        //     test: ['.js', '.ts', '.css', '.scss'],
        //     filename: '[name].js.map',
        //     exclude: ['vendor.']
        // })
    ],
    optimization: {
        splitChunks: {
            cacheGroups: {
                commons: {
                    test: /[\\/]node_modules[\\/]/,
                    name: 'vendors',
                    chunks: 'all'
                }
            }
        }
    },
    devServer: {
        historyApiFallback: true,
        open: true,
        overlay: true,
        port: 4100,
        proxy: {
            // https://webpack.js.org/configuration/dev-server/#devserverproxy
            '/api': {
                target: 'http://localhost:4300',
                pathRewrite: {
                    '^/api' : ''
                }
            }
        }
    }
});
