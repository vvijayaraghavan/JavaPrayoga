package vij.core.enumex.operators;

import java.util.ArrayList;
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

    NUM_OPS(EnumSet.copyOf(Arrays.asList(GenericOperations.values())),
            EnumSet.copyOf(Arrays.asList(NumericOperations.values()))),
    ;


    private final List<Enum> allowedOperations = new ArrayList<>();
    private final List<String> allowedOperationNames = new ArrayList<>();

    Operator(EnumSet... myEnumSet) {

        int enumSetArrLen = myEnumSet.length;
        for (int i=0 ; i<enumSetArrLen ; i++) {

            EnumSet enmSet = myEnumSet[i];
            allowedOperations.addAll(enmSet);

            Iterator<Enum> enmSetItr = enmSet.iterator();
            while (enmSetItr.hasNext()) {

                Enum myOprEnm = enmSetItr.next();
                allowedOperationNames.add(myOprEnm.toString());
            }
        }
    }

    /**
     * This provides the allowed operations for the given data type as a List of Enum
     *
     * @return List<Enum>
     */
    public List<Enum> getAllowedOperations() {

        return allowedOperations;
    }

    /**
     * This provides the allowed operations for the given data type as a List of String values.
     * The String value is the operatorName equivalent of the corresponding field defined in the respective enum class.
     *
     * @return List<String>
     */
    public List<String> getAllowedOperationNames() {

        return allowedOperationNames;
    }

    private enum GenericOperations implements IOperator {

        EQUAL("eq"),
        NOT_EQUAL("neq")
        ;

        private String operationName;
        GenericOperations(String operationName) {

            this.operationName = operationName;
        }

        public String getOperationName() {

            return operationName;
        }

        @Override
        public String toString() {

            return getOperationName();
        }
    }

    private enum NumericOperations implements IOperator  {

        GREATER_THAN("gt"),
        LESS_THAN("lt"),
        GREATER_THAN_OR_EQUAL("gte"),
        LESS_THAN_OR_EQUAL("lte")
        ;

        private String operationName;
        NumericOperations(String operationName) {

            this.operationName = operationName;
        }

        public String getOperationName() {

            return operationName;
        }

        @Override
        public String toString() {

            return getOperationName();
        }
    }

    private enum StringOperations {

        CONTAINS("contains"),
        BEGIN_WITH("beginWith"),
        ENDS_WITH("endsWith"),
        ;

        private String operationName;

        StringOperations(String operationName) {

            this.operationName = operationName;
        }

        public String getOperationName() {

            return operationName;
        }

        @Override
        public String toString() {

            return getOperationName();
        }
    }
}