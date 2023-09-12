package com.eyuphancase.eyuphancase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyuphancase.eyuphancase.model.vm.Employee.AddEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.DeleteEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetAllEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.GetEmployeeVm;
import com.eyuphancase.eyuphancase.model.vm.Employee.UpdateEmployeeVm;
import com.eyuphancase.eyuphancase.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Çalışan İşlemleri")
@SecurityRequirement(name = "employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
        description = "Bu metod, sistemde bulunan tüm çalışanları listelemek için kullanılır.",
        summary =   "Bu metod tüm çalışanları listeler.",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @GetMapping()
    public ResponseEntity<List<GetAllEmployeeVm>> getAllEmployeeVm(){
        List<GetAllEmployeeVm> getAllCategoryVm = employeeService.getAllEmployeeVm();
        return ResponseEntity.ok(getAllCategoryVm);
    }




    @Operation(
        description = "Bu metod, belirli bir çalışana ait verileri listelemek için kullanılır. {id} parametresi, istenen çalışanın benzersiz tanımlayıcısını belirtir. API'ye gönderilen bu {id} parametresi sayesinde, ilgili çalışana ait olan Çalışanlar filtrelenir ve listelenir.",
        summary =   "Bu metod, {id} parametresi gönderilen belirtilen çalışanları listelemek için kullanılır.",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetEmployeeVm> getEmployeeVm(@PathVariable  Long id){
        GetEmployeeVm getEmployeeVm2 = employeeService.getEmployeeVm(id);
        return ResponseEntity.ok(getEmployeeVm2);
    }

    @Operation(
        description = "Bu metod, yeni çalışan eklemesi için kullanılır. Yeni bir çalışan eklemek isteyen, bu metod aracılığıyla gerekli bilgileri sisteme iletebilir.",
        summary =   "Bu metod, yeni çalışanlar eklenmesine izin verir.",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @PostMapping
    public ResponseEntity<AddEmployeeVm> addEmployeeVm(@RequestBody @Valid AddEmployeeVm addEmployeeVm){
        AddEmployeeVm addEmployeeVm2 = employeeService.addEmployeeVm(addEmployeeVm);
        return ResponseEntity.status(HttpStatus.CREATED).body(addEmployeeVm2);
    }



    @Operation(
        description = "Bu metod, \"id\" çalışanına göre silme işlemi gerçekleştirmesi için kullanılır.",
        summary =   "Bu metod, belirtilen çalışanı silmesine izin verir. ",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEmployeeVm> deleteEmployeeVm(@PathVariable Long id){
        DeleteEmployeeVm deleteCategoryVm2 = employeeService.deleteEmployeeVm(id);
        return ResponseEntity.ok(deleteCategoryVm2);
    }


    @Operation(
        description = "Bu metod, \"id\" çalışanına göre güncelleme işlemi gerçekleştirmesi için kullanılır.",
        summary =   "Bu metod, belirtilen çalışanı güncellemesine izin verir. ",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<UpdateEmployeeVm> updateCategoryVm(@PathVariable Long id,@RequestBody @Valid UpdateEmployeeVm updateEmployeeVm){
        UpdateEmployeeVm updateEmployeeVm2 = employeeService.updateEmployeeVm(id,updateEmployeeVm);
        return ResponseEntity.ok(updateEmployeeVm2);
    }
    
}
