package com.mariofernandes.javapoc.junit.interfaces;


import com.mariofernandes.javapoc.junit.extension.TimingExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("timed")
@ExtendWith(TimingExtension.class)
interface TimeExecutionLogger {
}
