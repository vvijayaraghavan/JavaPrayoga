package vij.core.enumex.operators;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vijay on 2017, March 27.
 *
 * This enum is comprised with set of different Operators for different data-types, say String, Numberic, Date etc.
 * This encapsulates those operations as an enum and provides them.
 */
public enum Operator {

    STRING_OPERATIONS(EnumSet.copyOf(Arrays.asList(StringOperations.values()))),
    NUMERIC_OPERATIONS(EnumSet.copyOf(Arrays.asList(NumericOperations.values()))),
    GENERIC_OPERATIONS(EnumSet.copyOf(Arrays.asList(GenericOperations.values()))),

    STR_OPS(StringOperations.CONTAINS, StringOperations.BEGIN_WITH, GenericOperations.EQUAL),

    NUM_OPS(EnumSet.copyOf(Arrays.asList(GenericOperations.values())),
            EnumSet.copyOf(Arrays.asList(NumericOperations.values()))),
    ;

    private EnumSet setOfOperations ;
    private Enum[] operatorsArr;
    private EnumSet[] setOfOperationsArr ;

    Operator(EnumSet setOfOperations) {

        this.setOfOperations = setOfOperations;
    }

    Operator(Enum... myEnum) {

        int enumArrLen = myEnum.length;
        operatorsArr = new Enum[enumArrLen];
        int i=0;
        for (Enum enumObj : myEnum) {

            operatorsArr[i] = myEnum[i];
            i++;
        }
    }

    Operator(EnumSet... myEnumSet) {

        int enumSetArrLen = myEnumSet.length;
        setOfOperationsArr = new EnumSet[enumSetArrLen];
        System.arraycopy(myEnumSet, 0, setOfOperationsArr, 0, enumSetArrLen);
//        for (int i=0; i< enumSetArrLen ; i++) {
//
//            setOfOperationsArr[i] = myEnumSet[i];
//        }
    }

    public EnumSet[] setOfOperationsAllowed() {

        return setOfOperationsArr;
    }

    public Enum[] getOperators() {
        return operatorsArr;
    }

    public EnumSet getAllowedOperations() {

        return setOfOperations;
    }

    private enum GenericOperations implements IOperator {

        EQUAL("eq"),
        NOT_EQUAL("neq")
        ;

        private String operationType;
        GenericOperations(String operationType) {

            this.operationType = operationType;
        }

        public String getOperationType() {

            return operationType;
        }

        @Override
        public String toString() {

            return getOperationType();
        }
    }

    private enum NumericOperations implements IOperator  {

        GREATER_THAN("gt"),
        LESS_THAN("lt"),
        GREATER_THAN_OR_EQUAL("gte"),
        LESS_THAN_OR_EQUAL("lte")
        ;

        private String operationType;
        NumericOperations(String operationType) {

            this.operationType = operationType;
        }

        public String getOperationType() {

            return operationType;
        }

        @Override
        public String toString() {

            return getOperationType();
        }
    }

    private enum StringOperations {

        CONTAINS("contains"),
        BEGIN_WITH("beginWith"),
        ENDS_WITH("endsWith"),

        ;

        private String operationType;
        private List<String> allowedOperations;
        StringOperations(String operationType) {

            this.operationType = operationType;
        }

        public String getOperationType() {

            return operationType;
        }

        @Override
        public String toString() {

            return getOperationType();
        }
    }
}