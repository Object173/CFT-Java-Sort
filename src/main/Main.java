package main;

import utils.SorterFactory;
import utils.SorterHelper;

public final class Main {

    public static void main(final String[] args) {
        if(args != null && args.length > 0 && args[0] != null && args[0].equals(Constants.PARAMETER_HELP)) {
            System.out.println(Constants.MESSAGE_HELP);
            return;
        }
        if(args == null || args.length < Constants.PARAMETERS_COUNT) {
            System.out.println(Constants.ERROR_FEW_PARAMETERS);
            return;
        }
        if(args.length > Constants.PARAMETERS_COUNT) {
            System.out.println(Constants.ERROR_MUCH_PARAMETERS);
            return;
        }

        final String inputFileName = args[0];
        if(inputFileName == null) {
            System.out.println(Constants.ERROR_INVALID_PARAMETER + Constants.PARAMETER_INPUT_FNAME);
            return;
        }

        final String outputFileName = args[1];
        if(outputFileName == null) {
            System.out.println(Constants.ERROR_INVALID_PARAMETER + Constants.PARAMETER_OUTPUT_FNAME);
            return;
        }

        final String paramType = args[2];
        final Class dataType;
        switch (paramType) {
            case Constants.PARAMETER_INTEGER:
                dataType = Integer.class;
                break;
            case Constants.PARAMETER_STRING:
                dataType = String.class;
                break;
            default:
                System.out.println(Constants.ERROR_INVALID_PARAMETER + paramType);
                return;
        }
        final String sortType = args[3];
        final boolean isAsc;
        switch (sortType) {
            case Constants.PARAMETER_ASC:
                isAsc = true;
                break;
            case Constants.PARAMETER_DESC:
                isAsc = false;
                break;
            default:
                System.out.println(Constants.ERROR_INVALID_PARAMETER + sortType);
                return;
        }

        final SorterHelper sorter = SorterFactory.newInstance(dataType);
        final SorterHelper.Result result = sorter.sortFile(inputFileName, outputFileName, isAsc);

        if(result.equals(SorterHelper.Result.SUCCESS)) {
            System.out.println(Constants.MESSAGE_SUCCESS);
        } else
        if(result.equals(SorterHelper.Result.INVALID_ARGS)) {
            System.out.println(Constants.ERROR_INVALID_ARGS);
        } else
        if(result.equals(SorterHelper.Result.INVALID_FORMAT)) {
            System.out.println(Constants.ERROR_INVALID_DATA_FORMAT);
        } else
        if(result.equals(SorterHelper.Result.FILE_NOT_FOUND)) {
            System.out.println(Constants.ERROR_FILE_NOT_FOUND);
        } else
        if(result.equals(SorterHelper.Result.ERROR_IO_SYSTEM)) {
            System.out.println(Constants.ERROR_IO_SYSTEM);
        } else
        if(result.equals(SorterHelper.Result.FAIL)) {
            System.out.println(Constants.ERROR_FATAL);
        }
    }

}
