package com.lzq.modle;

/**
 * 基础数据，每个接口都会包含的公共数据。T表示与服务器沟通好返回的数据
 */

public class BaseResponse<T> {
    public static BaseResponse sBaseResponseInstance;

    public String getDataName() {
        return mDataName;
    }

    public void setDataName(String dataName) {
        mDataName = dataName;
    }

    private String mDataName;
    public static BaseResponse getInstance() {
        if (null == sBaseResponseInstance) {
            synchronized (BaseResponse.class) {
                if (null == sBaseResponseInstance) {
                    sBaseResponseInstance = new BaseResponse();
                }
            }
        }
        return sBaseResponseInstance;
    }




    private T subjects;
    private int error_code;
    private String error;

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private T newslist;

    public T getNewslist() {
        return newslist;
    }

    public void setNewslist(T newslist) {
        this.newslist = newslist;
    }


    public boolean isReturnStatus;

  public T getData() {
          return data;
      }

      public void setData(T data) {
          this.data = data;
      }

      private T  data;

    public void setReturnStatus(boolean returnStatus) {
        isReturnStatus = returnStatus;
    }

    public boolean isReturnStatus() {
        return isReturnStatus;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "mDataName='" + mDataName + '\'' +
                ", subjects=" + subjects +
                ", error_code=" + error_code +
                ", error='" + error + '\'' +
                ", newslist=" + newslist +
                ", isReturnStatus=" + isReturnStatus +
                ", data=" + data +
                '}';
    }
}
