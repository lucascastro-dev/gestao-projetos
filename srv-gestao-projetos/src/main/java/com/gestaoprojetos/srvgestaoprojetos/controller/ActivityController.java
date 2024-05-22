package com.gestaoprojetos.srvgestaoprojetos.controller;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityDto;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IFindActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.CreateOrUpdateActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.DeleteActivityManager;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.FindActivityManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Atividades",
        description = "Endpoint responsável pela manutenção das atividades")
@RestController
@RequestMapping("/activity")
public class ActivityController {
    private final IActivityManager<IActivityForm> createOrUpdate;
    private final IActivityManager<IActivityForm> delete;
    private final IFindActivityManager<IActivityDto, IActivityForm> find;

    @Autowired
    public ActivityController(CreateOrUpdateActivityManager createOrUpdate,
                              DeleteActivityManager delete,
                              FindActivityManager find) {
        this.createOrUpdate = createOrUpdate;
        this.delete = delete;
        this.find = find;
    }

    @PostMapping()
    @Operation(summary = "Criar uma nova atividade")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ActivityForm activityForm) {
        createOrUpdate.runRequest(activityForm);
    }

    @PutMapping()
    @Operation(summary = "Atualizar uma atividade")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ActivityForm activityForm) {
        createOrUpdate.runRequest(activityForm);
    }

    @DeleteMapping(value = "/{idActivity}")
    @Operation(summary = "Deletar uma atividade")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idActivity) {
        delete.runRequest(ActivityForm.builder().idActivity(idActivity).build());
    }

    @GetMapping
    @Operation(summary = "Buscar todas as atividades")
    @ResponseStatus(HttpStatus.OK)
    public List<IActivityDto> findAll() {
        return find.all();
    }

    @GetMapping(value = "/{idActivity}")
    @Operation(summary = "Buscar uma atividade pelo ID")
    @ResponseStatus(HttpStatus.OK)
    public IActivityDto findById(@PathVariable Long idActivity) {
        return find.get(ActivityForm.builder().idActivity(idActivity).build());
    }
}
