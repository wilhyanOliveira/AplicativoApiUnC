package Data;

    public class Resultado<T> {
        // hide the private constructor to limit subclass types (Success, Error)
        public Resultado() {
        }

        @Override
        public String toString() {
            if (this instanceof Resultado.Success) {
                Resultado.Success success = (Resultado.Success) this;
                return "Success[data=" + success.getData().toString() + "]";
            } else if (this instanceof Resultado.Error) {
                Resultado.Error error = (Resultado.Error) this;
                return "Error[exception=" + error.getError().toString() + "]";
            }
            return "";
        }

        // Success sub-class
        public final static class Success<T> extends Resultado {
            private T data;

            public Success(T data) {
                this.data = data;
            }

            public T getData() {
                return this.data;
            }
        }

        // Error sub-class
        public final static class Error extends Resultado {
            private Exception error;

            public Error(Exception error) {
                this.error = error;
            }

            public Exception getError() {
                return this.error;
            }
        }
    }
