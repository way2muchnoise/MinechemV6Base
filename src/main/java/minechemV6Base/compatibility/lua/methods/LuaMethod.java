package minechemV6Base.compatibility.lua.methods;

import net.minecraft.tileentity.TileEntity;

public abstract class LuaMethod{

    private final String methodName;
	private final String args;
	
    public LuaMethod(String methodName){
        this(methodName,"()");
    }
	
	public LuaMethod(String methodName, String args){
        this.methodName = methodName;
		this.args = args;
	}

	public abstract Object[] call(TileEntity te, Object[] args) throws Exception;
	
    public String getMethodName(){
        return methodName;
    }
    
    public String getArgs() {
    	return args;
    }

    public String[] getDetails() {
        return new String[0];
    }
}
