/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.employee.task;

import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.result.PragmaticBookSelfResult;
import com.pragmatic.bookself.result.ResultCode;
import com.pragmatic.bookself.result.ResultCode.ResultCodes;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.task.core.PragmaticBookselfTask;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class DeleteEmployeeDataTask extends PragmaticBookselfTask<EmployeeEntity> {
	private int empId;

	public DeleteEmployeeDataTask(int empId) {
		this.empId = empId;
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pragamtic.bookself.task.core.PragmaticBookselfTask#validateParameter(
	 * com.pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pragamtic.bookself.task.core.PragmaticBookselfTask#execute(com.
	 * pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected PragmaticBookSelfResult<EmployeeEntity> execute(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		PragmaticBookSelfResult<EmployeeEntity> result = new PragmaticBookSelfResult<EmployeeEntity>();
		EmployeeStorageManager.getInstance().deleteEmployeeData(empId, context);
		EmployeeEntity employeeEntity = EmployeeStorageManager.getInstance().deleteEmployeeData(empId, context);
		result.setRestltedObject(employeeEntity);
		result.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		// TODO Auto-generated method stub
		return result;
	}

}
