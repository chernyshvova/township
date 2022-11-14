package com.helpshift.p042db.smartintents.tables;

/* renamed from: com.helpshift.db.smartintents.tables.SmartIntentWordProbabilitiesTable */
public interface SmartIntentWordProbabilitiesTable {
    public static final String TABLE_NAME = "si_word_probabilities_table";

    /* renamed from: com.helpshift.db.smartintents.tables.SmartIntentWordProbabilitiesTable$Columns */
    public interface Columns {
        public static final String LOCAL_ID = "local_id";
        public static final String SI_WORD_PROBABILITIES_MODEL_LOCAL_ID = "model_local_id";
        public static final String SI_WORD_PROBABILITIES_PROBABILITIES = "probabilities";
        public static final String SI_WORD_PROBABILITIES_WORD = "word";
    }
}
