package com.br.client.configuracao;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.rpc.RpcRequestBuilder;

public class UnoRpcRequestBuilder extends RpcRequestBuilder{

	@Override
	protected RequestBuilder doCreate(String serviceEntryPoint) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, serviceEntryPoint);
		builder.setTimeoutMillis(1000 * 160 );
		return builder;
	}
}
