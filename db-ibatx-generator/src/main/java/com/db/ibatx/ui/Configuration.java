package com.db.ibatx.ui;

import com.db.ibatx.generator.template.TableDetail;
import com.db.ibatx.ui.data.Logger;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.List;

@Getter
@Setter
public class Configuration {

    private String baseDir;

    private Logger logger;

    private JFrame jFrame;

    private String project;

    private List<TableDetail> tableList;

    public Configuration() {
        this.logger = new Logger();
    }


}
