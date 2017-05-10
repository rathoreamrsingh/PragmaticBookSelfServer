/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.employee.task;

import com.pragamatic.bookself.exception.PragmaticBookSelfException;
import com.pragamatic.bookself.result.PragmaticBookSelfResult;
import com.pragamatic.bookself.result.ResultCode;
import com.pragamatic.bookself.result.ResultCode.ResultCodes;
import com.pragamatic.bookself.task.core.PragmaticBookselfTask;
import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class UpdateEmployeeDataTask extends PragmaticBookselfTask<EmployeeEntity> {
	private EmployeeEntity employee = null;

	//constructor
	public UpdateEmployeeDataTask(EmployeeEntity employee) {
		this.employee = employee;
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
		EmployeeEntity updateEmployee = EmployeeStorageManager.getInstance().updateEmployeeData(employee, context);
		PragmaticBookSelfResult<EmployeeEntity> pragamaticBookSelfResult = new PragmaticBookSelfResult<EmployeeEntity>();
		pragamaticBookSelfResult.setRestltedObject(updateEmployee);
		pragamaticBookSelfResult.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));

		return pragamaticBookSelfResult;
	}

}
