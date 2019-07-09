const webpack = require('webpack');
const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: {
        main: path.resolve(__dirname, 'src', 'main.ts')
    },
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, 'dist')
    },
    devtool: 'inline-source-map',
    module: {
        rules: [{
            test: /\.ts$/,
            use: [{
                loader: 'ng-annotate-loader',
                options: { ngAnnotate: 'ng-annotate-patched', sourcemap: true }
            }, {
                loader: 'ts-loader',
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
            loader: 'html-loader',
            options: { minimize: false }
        }]
    },
    resolve: {
        extensions: ['.ts', '.js', '.json']
    },
    plugins: [
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: path.resolve(__dirname, 'src', 'index.html')
        }),
        new MiniCssExtractPlugin({
            filename: '[name].[contenthash:4].css',
            chunkFilename: '[id].[contenthash:4].css'
        })
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
    }
};
