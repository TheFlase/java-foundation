package com.wgc.lab.netty;

import org.jboss.netty.channel.*;

/**
 * Created by Administrator on 8/1/2018.
 */
public class ServerHelloHandler extends SimpleChannelHandler{

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("***Server messageReceived***");
        String s = (String) e.getMessage();
        System.out.println(s);


        //回写数据
        ctx.getChannel().write("hi ,i am from server");
        super.messageReceived(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("***exceptionCaught***");
        super.exceptionCaught(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("***channelConnected***");
        super.channelConnected(ctx, e);
    }

    /**
     * desc:要在建立了连接的前提断开才会触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("***channelDisconnected***");
        super.channelDisconnected(ctx, e);
    }

    /**
     * desc:关闭或者断开连接的时候,就算没有建立了连接,也会触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("***channelClosed***");
        super.channelClosed(ctx, e);
    }
}
