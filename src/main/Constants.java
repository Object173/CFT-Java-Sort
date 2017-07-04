package main;

final class Constants {
    static final String PARAMETER_HELP = "-help";
    static final String PARAMETER_INTEGER = "-i";
    static final String PARAMETER_STRING = "-s";
    static final String PARAMETER_ASC = "-a";
    static final String PARAMETER_DESC = "-d";

    static final String PARAMETER_INPUT_FNAME = "input file name ";
    static final String PARAMETER_OUTPUT_FNAME = "output file name ";

    static final int PARAMETERS_COUNT = 4;

    private static final String HELP_HINT = "Use the command " + PARAMETER_HELP + " to get help";

    static final String ERROR_FEW_PARAMETERS = "Too few input parameters. " + HELP_HINT;
    static final String ERROR_MUCH_PARAMETERS = "Too much input parameters. " + HELP_HINT;
    static final String ERROR_INVALID_ARGS = "Invalid input args";
    static final String ERROR_INVALID_DATA_FORMAT = "Invalid input data format";
    static final String ERROR_FILE_NOT_FOUND = "File not found";
    static final String ERROR_IO_SYSTEM = "Error IO system";
    static final String ERROR_INVALID_PARAMETER = "Invalid input parameter ";
    static final String ERROR_FATAL = "Unexpected error";

    static final String MESSAGE_HELP = "parameters format:\n" +
            "{input file name} {output file name} {data type} {sorting order}\n" +
            "Command list:\n" +
            PARAMETER_HELP + " (open command list)\n" +
            PARAMETER_INTEGER + " (data type is integer)\n" +
            PARAMETER_STRING + " (data type is string)\n" +
            PARAMETER_ASC + " (sort in ascending order)\n" +
            PARAMETER_DESC + " (sorting in decreasing order)";
    static final String MESSAGE_SUCCESS = "Success";
}
